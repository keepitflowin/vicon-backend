<?php
class BMP
{
    public static function imagecreatefrombmp($filename)
    {
        return imagecreatefrombmp($filename);
    }
}

function imagecreatefrombmp($filename)
{
    $f = fopen($filename, "rb");

    # read header    
    $header = fread($f, 54);
    $header = unpack('c2identifier/Vfile_size/Vreserved/Vbitmap_data/Vheader_size/' .
                        'Vwidth/Vheight/vplanes/vbits_per_pixel/Vcompression/Vdata_size/'.
                        'Vh_resolution/Vv_resolution/Vcolors/Vimportant_colors', $header);

    if ($header['identifier1'] != 66 or $header['identifier2'] != 77)
    {
        die('Not a valid bmp file');
    }
    
    if ($header['bits_per_pixel'] != 24)
    {
        die('Only 24bit BMP images are supported');
    }
    
    $wid2 = ceil((3*$header['width']) / 4) * 4;
    
    $wid = $header['width'];
    $hei = $header['height'];

    $img = imagecreatetruecolor($header['width'], $header['height']);

    # read pixels    
    for ($y=$hei-1; $y>=0; $y--)
    {
        $row = fread($f, $wid2);
        $pixels = str_split($row, 3);
        for ($x=0; $x<$wid; $x++)
        {
            imagesetpixel($img, $x, $y, dwordize($pixels[$x]));
        }
    }
    fclose($f);            
    
    return $img;
}    

function dwordize($str)
{
    $a = ord($str[0]);
    $b = ord($str[1]);
    $c = ord($str[2]);
    return $c*256*256 + $b*256 + $a;
}

?>