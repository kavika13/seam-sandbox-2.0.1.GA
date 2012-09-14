package net.happypath;

public interface Column<TRow>
{
	String getHeaderLabelKey();
	Object getValue(TRow row);
}
