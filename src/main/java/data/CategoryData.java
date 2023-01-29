package data;

public enum CategoryData {
    POPULAR_COURSES("Популярные курсы"),
    SPECIALIZATION("Специализация"),
    RECOMMENDATIONS("Рекомендации для вас");

    final String name;

    CategoryData(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
