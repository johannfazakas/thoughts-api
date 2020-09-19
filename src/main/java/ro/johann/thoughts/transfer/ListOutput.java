package ro.johann.thoughts.transfer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
public class ListOutput<T> {

    private final List<T> items;
    private final int count;

    public ListOutput(List<T> items, int count) {
        this.items = items;
        this.count = count;
    }
}
