class Solution {
public:
    bool check(string s,string goal)
    {
        if(s == goal)
        {
            return true;
        }
        return false;
    }
    bool rotateString(string s, string goal) 
    {
        for(int i=0;i<s.length();i++)
        {
            string temp = "";
            temp = s.substr(1,s.length()-1);
            temp = temp + s[0];
            s = temp;
            cout<<s<<endl;
            bool ans = check(s,goal);
            if(ans)
            {
                return true;
            }
        }
        return false;
    }
};