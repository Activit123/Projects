public class test {
    public static void TiparesteDrum(char[][] c,char[][] t,int n){
        System.out.println("Nr.maxim de comori:" +  + c[0][0] );
        int i = 0;
        int j = 0;
        System.out.println( i + j );
        while(  i<n ){
            if( c[i][j]-t[i][j] ==  c[i+1][j]  ){
                i = i+1;
            } else {
                i = i+1;
                j = j+1;
            }
            System.out.println( i + j );
        }
    }
    public static int ValoareLipsă_v3(int[] A, int n){
	 //calculăm suma elementelor mulţimii A;
        int suma = 0;
        int i;
        for( i =  0;  i < n-2 ;  i ++ ){
            suma = suma + A[i];
        }
 //determinăm elementul lipsă;
        return n*(n+1)/2 - suma;

    }
    public static int ValoareLipsă_v2(int[] A, int n){
        // alocăm memorie pentru tabloul prezent
        int[] prezent = new int[n];
        int i;
        // iniţializăm tabloul de prezenţă cu 0
        for( i =  0;  i < n-1 ;  i ++ ){
            prezent[i] = 0;
        }
//pentru fiecare valoare din mulţimea A
// memorăm prezenţa ei în tabloul prezent
        for( i =  0;  i < n-2 ;  i ++ ){
            prezent[A[i]-1] = 1;
        }
//căutăm elementul lipsă
        for( i =  0;  i < n-1 ;  i ++ ){
            if( prezent[i] == 0 ){
                return i + 1;
            }
        }
        return 0;
    }



}
