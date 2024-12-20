public class q58FillingBookcaseShelves {


    // You are given an array books where books[i] = [thicknessi, heighti] indicates the thickness and height of the ith book.
    // You are also given an integer shelfWidth. We want to place these books in order onto bookcase shelves that have a total width 
    // shelfWidth. We choose some of the books to place on this shelf such that the sum of their thickness is less than or equal to 
    // shelfWidth, then build another level of the shelf of the bookcase so that the total height of the bookcase has increased by the
    //  maximum height of the books we just put down. We repeat this process until there are no more books to place.
    // Note that at each step of the above process, the order of the books we place is the same order as the given sequence of books.
    // For example, if we have an ordered list of 5 books, we might place the first and second book onto the first shelf, the third
    //  book on the second shelf, and the fourth and fifth book on the last shelf.
    // Return the minimum possible height that the total bookshelf can be after placing shelves in this manner.
    // Input: books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelfWidth = 4
    // Output: 6
    // Explanation:
    // The sum of the heights of the 3 shelves is 1 + 3 + 2 = 6.
    // Notice that book number 2 does not have to be on the first shelf.

     public static void main(String[] args) {
        q58FillingBookcaseShelves solution = new q58FillingBookcaseShelves();
        int[][] books = {
            {1, 3},
            {2, 4},
            {3, 2}
        };
        int shelfWidth = 6;
        int result = solution.minHeightShelves(books, shelfWidth);
        System.out.println("Minimum height of shelves: " + result);
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            int w = books[i - 1][0], h = books[i - 1][1];
            f[i] = f[i - 1] + h;
            for (int j = i - 1; j > 0; --j) {
                w += books[j - 1][0];
                if (w > shelfWidth) {
                    break;
                }
                h = Math.max(h, books[j - 1][1]);
                f[i] = Math.min(f[i], f[j - 1] + h);
            }
        }
        return f[n];
    }

}
