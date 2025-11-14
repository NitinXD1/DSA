class Solution {
    class SegmentTree{
        int[] tree;
        int[] arr;
        int n;

        public SegmentTree(int[] a){
            arr = a;
            n = a.length;
            tree = new int[n*4];
            build(0,0,n-1);
        }

        public void build(int node,int l,int r){
            if(l == r){
                tree[node] = arr[l];
                return;
            }

            int mid = l + (r-l)/2;
            build(2*node+1,l,mid);
            build(2*node+2,mid+1,r);
            tree[node] = tree[2*node+1] + tree[2*node+2];
        }

        public int query(int node,int l,int r,int ql,int qr){
            if(qr < l || r < ql)return 0;

            if(qr >= r &&  ql <= l)return tree[node];

            int mid = l + (r-l)/2;

            return query(2*node+1,l,mid,ql,qr) + query(2*node+2,mid+1,r,ql,qr);
        }

        public void update(int node,int l,int r,int index,int val){
            if(l == r){
                tree[node] = val;
                return;
            } 

            int mid = l + (r-l)/2;

            if(index <= mid){
                update(2*node+1,l,mid,index,val);
            }
            else update(2*node+2,mid+1,r,index,val);

            tree[node] = tree[2*node+1] + tree[2*node+2];
        }
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int[] copy = nums.clone();
        Arrays.sort(copy);
        HashMap<Integer,Integer> hash = new HashMap<>();

        int index = 0;
        for(int i:copy)if(!hash.containsKey(i))hash.put(i,index++);

        int[] freq = new int[index];
        for(int i:copy)freq[hash.get(i)]++;

        SegmentTree sg = new SegmentTree(freq);

        for(int i=0;i<n;i++){
            int x = hash.get(nums[i]);
            if(x != 0)ans[i] = sg.query(0,0,index-1,0,x-1);
        }

        return ans;
    }
}