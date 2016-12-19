/**
 * Created by Ashutosh on 12/18/16.
 */
public class RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int rectA1, rectA2, rectA3;

        rectA1 = Math.abs(A - C) * Math.abs(B - D);
        rectA2 = Math.abs(E - G) * Math.abs(F - H);

        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int bottom = Math.max(B, F);
        int top = Math.min(D, H);

        rectA3 = Math.abs(left - right) * Math.abs(bottom - top);

        return rectA1 + rectA2 - rectA3;
    }

    public static void main(String[] args) {

    }

}
