public class Category {
    private String categoryName;
    private String word;

    public Category(String categoryName, String word) {
        this.categoryName = categoryName;
        this.word = word;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
    @Override
    public String toString() {
        return String.format("Category: %s, Word: %s", categoryName, word);
    }
}
