package com.mrdios.competencymatrix.java.interview.prepare;

/**
 * 静态嵌套类(Static Nested Class)和内部类（Inner Class）的不同
 *
 * @author huxiong
 * @date 2016-11-22 10:58
 */
public class Poker {

    private static String[] suites = {"红桃", "梅花", "方片", "黑桃"}; //四种花色
    private static int[] faces = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}; //点数

    private Card[] cards;

    public Poker() {
        cards = new Card[52];
        for (int i = 0; i < suites.length; i++) {
            for (int j = 0; j < faces.length; j++) {
                cards[i * 13 + j] = new Card(suites[i], faces[j]);
            }
        }
    }

    /**
     * 洗牌
     */
    public void shuffle() {
        for (int i = 0, len = cards.length; i < len; i++) {
            int index = (int) (Math.random() * len);
            Card temp = cards[index];
            cards[index] = cards[i];
            cards[i] = temp;
        }
    }

    /**
     * 发牌
     *
     * @param index 发牌位置
     * @return
     */
    public Card deal(int index) {
        return cards[index];
    }

    public class Card {
        private String suite; //花色
        private int face;  //点数

        public Card(String suite, int face) {
            this.suite = suite;
            this.face = face;
        }

        @Override
        public String toString() {
            String faceStr;
            switch (face) {
                case 1:
                    faceStr = "A";
                    break;
                case 11:
                    faceStr = "J";
                    break;
                case 12:
                    faceStr = "Q";
                    break;
                case 13:
                    faceStr = "K";
                    break;
                default:
                    faceStr = String.valueOf(false);
            }
            return suite + faceStr;
        }
    }

    public static void main(String[] args) {
        Poker poker = new Poker();
        poker.shuffle();
        Poker.Card c1 = poker.deal(0);
        //非静态内部类只能由外部类对象创建
        Poker.Card c2 = poker.new Card("红桃",1);

        System.out.println(c1);
        System.out.println(c2);
    }
}
