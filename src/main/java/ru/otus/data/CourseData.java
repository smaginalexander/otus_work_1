package ru.otus.data;

public enum CourseData  {
    BI_АНАЛИТИКА("BI-аналитика", "2023-02-28","Популярные курсы", 51800 ),
    СИСТЕМНЫЙ_АНАЛИТИК_ADVANCED("Системный аналитик. Advanced", "2023-02-27","Популярные курсы",176000),
    TEAM_LEAD("Team Lead", "2023-02-28","Популярные курсы",100000),
    ADMINISTRATOR_LINUX("Специализация Administrator Linux", "2023-01-28","Специализации",55000),
    СЕТЕВОЙ_ИНЖЕНЕР("Специализация сетевой инженер", "2023-02-27","Специализации",90000),
    MACHINE_LEARNING("Специализация Machine Learning", "2023-02-27","Специализации",70000),
    СИСТЕМНЫЙ_АНАЛИТИК("Специализация Системный аналитик", "2023-02-27","Специализации",100000),
    PYTHON("Специализация Python", "2023-02-27","Специализации",40000),
    IOS_DEVELOPER("Специализация iOS Developer", "2023-02-27","Специализации",90000),
    JAVA_DEVELOPER("Специализация Java-разработчик", "2023-03-29","Специализации",176000),
    ANDROID("Специализация Android", "2023-03-29","Специализации",130000),
    QA_AUTOMATION_ENGINEER("Специализация QA Automation Engineer", "2023-03-30","Специализации",123000),
    FULLSTACK_DEVELOPER("Специализация Fullstack Developer", "2023-03-30","Специализации",160000),
    C_PLUS("Специализация С++", "2023-03-31","Специализации",150000),
    C_SHARP("Специализация С#", "2023-04-26","Специализации",75000),
    PHP_DEVELOPER("Специализация PHP Developer", "2023-10-26","Специализации",45000),
    JAVA_QA_ENGINEER("Java QA Engineer. Basic", "2023-03-30","Рекомендации для вас",123000),
    QA_AUTOMATION_ENGINEER_REK("Специализация QA Automation Engineer", "2023-03-30","Рекомендации для вас",123000),
    JAVASCRIPT_QA_ENGINEER("JavaScript QA Engineer", "2023-03-29","Рекомендации для вас",76700);

    final String name;
    final String date;
    final String category;
    final Integer prise;

    CourseData(String name, String date, String category, Integer prise) {
        this.name = name;
        this.date = date;
        this.category = category;
        this.prise = prise;
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

    public Integer getPrise() {
        return this.prise;
    }
}
