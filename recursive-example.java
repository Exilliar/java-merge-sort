class recursive {
    public static void main(String[] args) {
        System.out.println(go(10));
    }
    public static int go(int a) {
        if (a == 1) return 1;// base case
        else {// step case
            return a + go(a-1);
        }
    }
}