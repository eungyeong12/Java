public class Task {
    int _priority;
    String _title;
    public Task() {}
    public Task(int priority, String _title) {
        this._priority = priority;
        this._title = _title;
    }

    public int getPriority() {
        return _priority;
    }

    public String getTitle() {
        return _title;
    }

    @Override
    public String toString() {
        String str = String.format("Task(%d, %s)", this._priority, this._title);
        return str;
    }
}
