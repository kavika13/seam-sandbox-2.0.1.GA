package net.happypath;

import java.util.List;

public interface RowProperty<TRow>
{
    List<String> getRowClasses(TRow row);
}
