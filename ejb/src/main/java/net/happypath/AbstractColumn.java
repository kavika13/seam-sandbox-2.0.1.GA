package net.happypath;

public abstract class AbstractColumn<TRow, TValue> implements Column<TRow>
{
    private String headerLabelKey;

    public AbstractColumn(String headerLabelKey)
    {
        this.headerLabelKey = headerLabelKey;
    }

    @Override
    public String getHeaderLabelKey()
    {
        return headerLabelKey;
    }

    public abstract TValue getValue(TRow row);
}
