package net.happypath;

public abstract class StringColumn<TRow> extends AbstractColumn<TRow, String>
{
    public StringColumn(String headerLabelKey)
    {
        super(headerLabelKey);
    }

    public abstract String getValue(TRow row);
}
