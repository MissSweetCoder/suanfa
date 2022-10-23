class Solution {

   public List<String> subdomainVisits(String[] cpdomains) {
       List<String> ans = new ArrayList<>();
       Map<String,Integer> counts = new HashMap<>();

       for(String cpdomain : cpdomains){
            String[] split = cpdomain.split(" ");
            Integer count = Integer.parseInt(split[0]);
            String domain = split[1];
            counts.put(domain,counts.getOrDefault(domain,0) + count);

            for(int i = 0 ; i < domain.length() ; i++){
                if(domain.charAt(i) == '.'){
                    String subDomain = domain.substring(i + 1);
                    counts.put(subDomain,counts.getOrDefault(subDomain,0) + count);
                }
            }
       }

       for(Map.Entry<String,Integer> entry : counts.entrySet()){
            ans.add(entry.getValue() + " " + entry.getKey());
        }

       return ans;
   }

}