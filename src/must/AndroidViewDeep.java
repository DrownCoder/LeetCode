package must;

/**
 * Author : xuan.
 * Date : 2019-04-01.
 * Description :获取View的最大深度
 */
class AndroidViewDeep {

    public int getViewDeep(View view, int height) {
        if (view == null) {
            return 0;
        }
        if (view instanceof ViewGroup) {
            if (((ViewGroup) view).getChildCount() > 0) {
                int max = height + 1;
                for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                    int deep = getViewDeep(((ViewGroup) view).getChildAt(i), height + 1);
                    if (max < deep) {
                        max = deep;
                    }
                }
                return max;
            } else {
                return height;
            }
        } else {
            return height;
        }
    }

    public int getViewDeep2(View view, int height) {
        if (view == null) {
            return 0;
        }
        if (view instanceof ViewGroup) {
            if (((ViewGroup) view).getChildCount() > 0) {
                int max = height + 1;
                for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                    int deep = getViewDeep2(((ViewGroup) view).getChildAt(i), height + 1);
                    max = Math.max(max, deep);
                }
                return max;
            } else {
                return height;
            }
        }else{
            return height;
        }
    }

    public static class ViewGroup extends View {
        public int getChildCount() {
            return 0;
        }

        public View getChildAt(int i) {
            return null;
        }
    }

    public static class View {

    }

}
