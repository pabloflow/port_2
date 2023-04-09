public class Port {


    public boolean stack(Container container){
        if (container == null)
            System.out.println("Container cannot be null");
        int index;
        if (container.getPriority() == 1)
            index = 0;

        else if (container.getPriority() == 2)
            index = 1;
        else
            index = 2;

        for (int i = index; i < 10; i++){
            for(int j = 0; j<12; j++){
                //if(containers[i][j] == null)

            }



        }


        return true;
    }

    public void remove(){

    }

    public void display(){

    }
    public int quantity(){
        return 0;
    }




}
