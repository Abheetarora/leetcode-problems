class Solution {
public:
    bool isRobotBounded(string s) {
         int dir=0,xpos = 0,ypos = 0;
        int t = 4;
        while(t-->0)
        {
            for(int i=0;i<s.size();i++)
            {
                if(s[i]=='R')
                {
                    dir+=3;
                    dir = dir%4;
                }
                else if(s[i] == 'L')
                {
                    dir+=1;
                    dir = dir%4;
                }
                else if(s[i] == 'G')
                {
                    if(dir == 0)
                    {
                        ypos++;
                    }
                    if(dir == 1)
                    {
                        xpos--;
                    }
                    if(dir == 2)
                    {
                        ypos--;
                    }
                    if(dir == 3)
                    {
                        xpos++;
                    }
                }
            }
        }
        if(xpos == 0 && ypos == 0)
        {
            return true;
        }
        else if(dir == 0)
        {
            return false;
        }
        return true;
        
    }
};