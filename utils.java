public final class utils {

    static int[][] colorDic(int index) {

        int[][] colorValue;
        
        switch (index) {
            case 0:
                colorValue = new int[][]{{255,255,255},{255,255,255}};
                break;
            case 2:
                colorValue = new int[][]{{238,228,218},{119,110,101}};
                break;
            case 4:
                colorValue = new int[][]{{237,224,200},{119,110,101}};
                break;
            case 8:
                colorValue = new int[][]{{242,177,121},{249,246,242}};
                break;
            case 16:
                colorValue = new int[][]{{245,149,99}, {249,246,242}};
                break;
            case 32:
                colorValue = new int[][]{{246,124,96}, {249,246,242}};
                break;
            case 64:
                colorValue = new int[][]{{246,94, 59}, {249,246,242}};
                break;
            case 128:
                colorValue = new int[][]{{237,207,115},{249,246,242}};
                break;
            case 256:
                colorValue = new int[][]{{237,204,98}, {249,246,242}};
                break;
            case 512:
                colorValue = new int[][]{{237,200,80}, {249,246,242}};
                break;
            case 1024:
                colorValue = new int[][]{{237,197,63}, {249,246,242}};
                break;
            case 2048:
                colorValue = new int[][]{{237,194,45}, {249,246,242}};
                break;
        
            default:
                colorValue = new int[][]{{0,0,0},{255,255,255}};
                break;
        }
        return colorValue;
    }

    static int[][] append(int[][] array, int[] newElement) {
        int[][] newArray = new int[array.length + 1][2];

        int i;
        for (i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[i] = newElement;
        return newArray;
    }

    static int[][] remove(int[][] array, int[] badApple) {

        int[][] newArray = {};

        for (int i = 0; i < array.length; i++) {
            if (!(array[i][0] == badApple[0] && array[i][1] == badApple[1])) {
                newArray = utils.append(newArray, array[i]);
            }
        }

        return newArray;
    }

    static void print_array(int[][] array) {
        System.out.print("[");
        for (int[] ele : array) {
            System.out.print("[");
            for (int ele2 : ele) {
                System.out.print(ele2);
                System.out.print(",");
            }
            System.out.print("]");
        }
        System.out.print("]\n");
    }

    static void print_array(int[] array) {
        System.out.print("[");
        for (int ele : array) {
            System.out.print(ele);
            System.out.print(",");
        }
        System.out.print("]\n");
    }
}
