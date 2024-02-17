public final class utils {

    // dictionary of colors
    static int[][] colorDic(int index) {
        
        switch (index) {
            case 0:    return new int[][]{{255,255,255},{255,255,255}};
            case 2:    return new int[][]{{238,228,218},{119,110,101}};
            case 4:    return new int[][]{{237,224,200},{119,110,101}};
            case 8:    return new int[][]{{242,177,121},{249,246,242}};
            case 16:   return new int[][]{{245,149,99}, {249,246,242}};
            case 32:   return new int[][]{{246,124,96}, {249,246,242}};
            case 64:   return new int[][]{{246,94, 59}, {249,246,242}};
            case 128:  return new int[][]{{237,207,115},{249,246,242}};
            case 256:  return new int[][]{{237,204,98}, {249,246,242}};
            case 512:  return new int[][]{{237,200,80}, {249,246,242}};
            case 1024: return new int[][]{{237,197,63}, {249,246,242}};
            case 2048: return new int[][]{{237,194,45}, {249,246,242}};
            default:   return new int[][]{{0,  0,  0},  {255,255,255}};
        }
    }

    // print 2d array
    static void print_array(int[][] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print("[");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
                if (!(j == (array[i].length - 1))) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if (!(i == (array.length - 1))) {
                System.out.print(",");
            }
        }
        System.out.print("]\n");
    }

    // print 1d array
    static void print_array(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (!(i == (array.length - 1))) {
                System.out.print(",");
            }
        }
        System.out.print("]\n");
    }
}
