import java.util.List;

/**
 * Write the specification here
 * check if the vector is the zero vector
 * compute the dot product with another vector
 * compute the length of the vector
 * compute the cross product with another vector
 * normalize the vector
 * scale the vector by a scalar
 */
public final class Vector3 {
    public List<Integer> list;

    public Vector3(List<Integer> l) {
        list = l;
    }

    public int crossProduct(Vector3 u){
        return 0;
    }

    publiv int dotProduct(Vector3 u){
        return 0;
    }
    public int length(){
        return list.size();
    }

    public Vector3 normalize(){
        int sum = 0;
        for(int i: list){
            sum += i;
        }
        for(int i = 0; i < list.size(); i++){
            list.set(i, list.get(i)/sum);
        }

        return this;
    }
}
