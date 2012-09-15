package net.happypath;

public abstract class GenderColumn<TRow> extends AbstractColumn<TRow, User.Gender>
{
    public GenderColumn(String headerLabelKey)
    {
        super(headerLabelKey);
    }

    public abstract User.Gender getValue(TRow row);
}
