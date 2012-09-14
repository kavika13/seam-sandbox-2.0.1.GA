package net.happypath;

import java.util.List;
import java.util.ArrayList;

public class GenderRowProperty implements RowProperty<User>
{
    public List<String> getRowClasses(User row)
    {
        List<String> result = new ArrayList<String>();

        switch(row.getGender())
        {
            case Male:
                result.add("male-gender");
                break;
            case Female:
                result.add("female-gender");
                break;
            case Other:
                result.add("other-gender");
                break;
        }

        return result;
    }
}
