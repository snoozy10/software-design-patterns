package io.github.snoozy10.softwarepatterns;

public abstract class Component {
    private final String name;
    public Component(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void printName(int level) {
        System.out.println(getLevelPrefix(level) + this.name);
    }
    public String getLevelPrefix(int level) {
        StringBuilder levelPrefixStr = new StringBuilder();
        if (level != 0) {
            levelPrefixStr.append("\t".repeat(level-1));
            levelPrefixStr.append("├──");
            levelPrefixStr.append("──".repeat(level-1));
            levelPrefixStr.append(" ");
        }
        return String.valueOf(levelPrefixStr);
    }
    public abstract void printHierarchy(int level);

}
