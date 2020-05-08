package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.List;

public final class CompositePostFilter implements IPostFilter {
    private List<IPostFilter> filters;
    public CompositePostFilter() {
        filters = new ArrayList<>();
    }

    @Override
    public boolean apply(Post post) {
        for (IPostFilter filter: filters) {
            if (!filter.apply(post)) {
                return false;
            }
        }
        return true;
    }

    public void addFilter(IPostFilter postFilter) {
        filters.add(postFilter);
    }

    public void clear() {
        this.filters.clear();
    }
}
