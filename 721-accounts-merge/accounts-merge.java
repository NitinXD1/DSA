class Solution {
    class DisjointSet{
        int[] parent;
        int[] size;

        DisjointSet(int n){
            parent = new int[n];
            size = new int[n];

            for(int i=0;i<n;i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findUPar(int index){
            if(parent[index] == index) return index;

            return parent[index] = findUPar(parent[index]);
        }

        public void union(int u,int v){
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);

            int size_u = size[ulp_u];
            int size_v = size[ulp_v];

            if(ulp_u == ulp_v) return;

            if(size_u > size_v){
                parent[ulp_v] = ulp_u;
                size[ulp_u] = size_u + size_v;
            }
            else{
                parent[ulp_u] = ulp_v;
                size[ulp_v] = size_u + size_v;
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);

        HashMap<String,Integer> mpp = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String str = accounts.get(i).get(j);
                if(!mpp.containsKey(str)){
                    mpp.put(str,i);
                }
                else{
                    ds.union(i,mpp.get(str));
                }
            }
        }

        List<List<String>> merged = new ArrayList<>();
        for(int i=0;i<n;i++)merged.add(new ArrayList<>());

        for(String email : mpp.keySet()){
            int node = ds.findUPar(mpp.get(email));
            merged.get(node).add(email);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(merged.get(i).isEmpty())continue;
            Collections.sort(merged.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(merged.get(i));
            ans.add(temp);
        }
        
        return ans;
    }
}