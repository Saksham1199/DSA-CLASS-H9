class Solution {
    int m,n;
    
    public boolean exist(char[][] b, String w) {
        m=b.length; n=b[0].length;
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(dfs(b,w,i,j,0))
                    return true;
        
        return false;
    }

    boolean dfs(char[][] b,String w,int r,int c,int k) {
        if(k==w.length()) return true;
        
        if(r<0||c<0||r>=m||c>=n||b[r][c]!=w.charAt(k))
            return false;
        
        char x=b[r][c];
        b[r][c]='#';
        
        boolean ok=dfs(b,w,r+1,c,k+1) ||
                   dfs(b,w,r-1,c,k+1) ||
                   dfs(b,w,r,c+1,k+1) ||
                   dfs(b,w,r,c-1,k+1);
        
        b[r][c]=x;
        return ok;
    }
}