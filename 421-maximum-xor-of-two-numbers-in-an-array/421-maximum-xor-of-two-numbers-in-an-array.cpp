class Trie
{
    private:
    Trie *child[2];
    int val;
    public:
    Trie() //constructor setting default values
    {
        child[0] = NULL; //if the bit is 0
        child[1] = NULL; //if the bit is 1
        val = 0;    //storing 0 initially
    }
    void insert(int num)
    {
        auto curr = this; //pointer
        for(int i = 30; i >= 0; i--) //for all 31 bits
        {
            bool bit = (num >> i) & 1;//from left to right store bits in bit
            if(curr->child[bit]) curr = curr->child[bit]; //if bit exist move next
            else 
            {
                curr->child[bit] = new Trie();//if not create one
                curr = curr->child[bit]; //move next
            }
        }
        curr->val = num; //store the number there.
    }
    
    int findbestmismatch(int num) 
    {
        auto curr = this; //pointer
        for(int i = 30; i >= 0; i--) //for all 31 bits
        {
            bool bit = (num >> i) & 1; //store bit in bit
            if(curr->child[!bit]) curr = curr->child[!bit]; //for opposite bit if exist
            else curr = curr->child[bit];             //same bit as opposite is not there.
        }
        return curr->val; //return the number from there.
    }
};

class Solution 
{
    public:
    int findMaximumXOR(vector<int>& nums) 
    {
        Trie t; //create a trie by instantiating and object 
        for(auto &i : nums) t.insert(i); //insert the numbers in the trie(bit wise)
        int ans = INT_MIN; //store minimum initially
        for(auto &i : nums) ans = max(ans, i ^ t.findbestmismatch(i)); //keep storing the best
        return ans; //return the best
    }
};