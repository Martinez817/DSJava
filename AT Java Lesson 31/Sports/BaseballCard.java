

 class BaseballCard {
    String name; // the name of the player on the card.
    int year; // the year the card was issued.

    public BaseballCard(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "BaseballCard{" +
                "name= '" + name + '\'' +
                ", year= " + year +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseballCard that = (BaseballCard) obj;
        return year == that.year && name.equals(that.name);
    }
}




