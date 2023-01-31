package data;

public enum CourseData  {
    BI_АНАЛИТИКА("BI-аналитика", "2023-02-28","Популярные курсы"),
    СИСТЕМНЫЙ_АНАЛИТИК_ADVANCED("Системный аналитик. Advanced", "2023-02-27","Популярные курсы"),
    TEAM_LEAD("Team Lead", "2023-02-28","Популярные курсы"),
    ADMINISTRATOR_LINUX("Специализация Administrator Linux", "2023-01-28","Специализации"),
    СЕТЕВОЙ_ИНЖЕНЕР("Специализация сетевой инженер", "2023-02-27","Специализации"),
    MACHINE_LEARNING("Специализация Machine Learning", "2023-02-27","Специализации"),
    СИСТЕМНЫЙ_АНАЛИТИК("Специализация Системный аналитик", "2023-02-27","Специализации"),
    PYTHON("Специализация Python", "2023-02-27","Специализации"),
    IOS_DEVELOPER("Специализация iOS Developer", "2023-02-27","Специализации"),
    JAVA_DEVELOPER("Специализация Java-разработчик", "2023-03-29","Специализации"),
    ANDROID("Специализация Android", "2023-03-29","Специализации"),
    QA_AUTOMATION_ENGINEER("Специализация QA Automation Engineer", "2023-03-30","Специализации"),
    FULLSTACK_DEVELOPER("Специализация Fullstack Developer", "2023-03-30","Специализации"),
    C_PLUS("Специализация С++", "2023-03-31","Специализации"),
    C_SHARP("Специализация С#", "2023-04-26","Специализации"),
    PHP_DEVELOPER("Специализация PHP Developer", "2023-10-26","Специализации"),
    JAVA_QA_ENGINEER("Java QA Engineer. Basic", "2023-03-30","Рекомендации для вас"),
    QA_AUTOMATION_ENGINEER_REK("Специализация QA Automation Engineer", "2023-03-30","Рекомендации для вас"),
    JAVASCRIPT_QA_ENGINEER("JavaScript QA Engineer", "2023-03-29","Рекомендации для вас");

    final String name;
    final String date;
    final String category;

    CourseData(String name, String date, String category) {
        this.name = name;
        this.date = date;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return this.date;
    }

    public String getCategory() {
        return this.category;
    }
}
