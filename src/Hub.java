import java.util.Arrays;

public class Hub {

    private Container[][] containers;

    @Override
    public String toString() {
       StringBuilder s = new StringBuilder() ;
       for(int i = 0; i<10; i++){
           for (int j = 0; j<12; j++){
               if (containers[i][j] == null){
                   s.append("E ");
              }
               else
                   s.append(("F "));
           }
           s.append("\n");
       }
       return s.toString();
   }



    public Hub() {
        containers = new Container[10][12];

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 12; j++){
                this.containers[i][j] = null;
            }
        }
    }

    public Container[][] getContainers() {
        return containers;
    }

    public void setContainers(Container[][] containers) {
        this.containers = containers;
    }

    public boolean stack(Container container){
        if (container == null){
            System.out.println("Container cannot be null");
            return false;
        }

        if (container.getPriority() == 1){
            for(int i = 0; i<10; i++){
                if (containers[10 - 1 -i][0] == null){
                    containers[10 - 1- i][0] = container;
                    return true;
                }
            }
        }

        else if (container.getPriority() == 2){
            for(int i = 0; i<10; i++){
                if (containers[10 - 1 - i][1] == null){
                    containers[10 - 1 - i][1] = container;
                    return true;
                }
            }
        }

        else{
            for (int i = 2; i < 12; i++){
                for(int j = 0; j < 10; j++) {
                    if (containers[10 -1- j][i] == null) {
                    containers[10-1 - j][i] = container;
                    return true;}
                }

        }

        }
        return false;

    }

    public boolean unstack( int column){


        for(int i = 0; i<10; i++){
            if(containers[i][column] != null){
                containers[i][column] = null;
                return true;
            }
            }

        return false;

    }

    public String searchid(int id){

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 12; j++){
                if ( containers[i][j] != null && containers[i][j].getId() == id)
                    return containers[i][j].toString();

            }
        }
        return "There is no container with ID " + id;


    }

    public int count(String country){
        int cnt = 0;
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 12; j++){
                if ( containers[i][j] != null && containers[i][j].getCountry() == country)
                    cnt++;

            }
        }
        return cnt;

    }










}
