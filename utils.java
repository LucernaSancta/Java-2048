public final class utils {

    // dictionary of colors
    static String[] colorDic(int index) {
        
        switch (index) {
            case 0:     return new String[]{"ff","ff"};
            case 2:     return new String[]{"ff","6d"};
            case 4:     return new String[]{"ff","6d"};
            case 8:     return new String[]{"f5","ff"};
            case 16:    return new String[]{"f1","ff"};
            case 32:    return new String[]{"ed","ff"};
            case 64:    return new String[]{"e8","ff"};
            case 128:   return new String[]{"f9","ff"};
            case 256:   return new String[]{"f9","ff"};
            case 512:   return new String[]{"f9","ff"};
            case 1024:  return new String[]{"f8","ff"};
            case 2048:  return new String[]{"f8","ff"};
            default:    return new String[]{"00","ff"};
        }
    }

    // append to a 2d array a new element
    static int[][] append(int[][] array, int[] newElement) {
        int[][] newArray = new int[array.length + 1][2];

        int i;
        for (i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[i] = newElement;
        return newArray;
    }

    // remove from a 2d array a element
    static int[][] remove(int[][] array, int[] badApple) {

        int[][] newArray = {};

        for (int i = 0; i < array.length; i++) {
            if (!(array[i][0] == badApple[0] && array[i][1] == badApple[1])) {
                newArray = utils.append(newArray, array[i]);
            }
        }

        return newArray;
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
