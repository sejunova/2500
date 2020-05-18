package academy.pocu.comp2500.lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListItem {
    private String text;
    private char bulletStyle;
    private List<ListItem> subListItems;

    public ListItem(String text) {
        this.text = text;
        this.bulletStyle = '*';
        this.subListItems = new ArrayList<>();
    }

    public ListItem(String text, char bulletStyle) {
        this(text);
        this.bulletStyle = bulletStyle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public char getBulletStyle() {
        return bulletStyle;
    }

    public void setBulletStyle(char bulletStyle) {
        this.bulletStyle = bulletStyle;
    }

    public void addSublistItem(ListItem listItem) {
        this.subListItems.add(listItem);
    }

    public ListItem getSublistItem(int index) {
        return this.subListItems.get(index);
    }

    public void removeSublistItem(int index) {
        this.subListItems.remove(index);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        addStringRecursive(this, stringBuilder, 0);
        return stringBuilder.toString();
    }

    private void addStringRecursive(ListItem listItem, StringBuilder stringBuilder, int depth) {
        stringBuilder.append(String.join("", Collections.nCopies(depth * 4, " ")));
        stringBuilder.append(String.format("%s %s%s", listItem.bulletStyle, listItem.text, System.lineSeparator()));
        for (ListItem subListItem : listItem.subListItems) {
            addStringRecursive(subListItem, stringBuilder, depth + 1);
        }
    }
}