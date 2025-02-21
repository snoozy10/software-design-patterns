package io.github.snoozy10.softwarepatterns;

public class File extends Component {

    public File(String name) {
        super(name);
    }

    public void printHierarchy(int level) {
        super.printName(level);
    }
}
