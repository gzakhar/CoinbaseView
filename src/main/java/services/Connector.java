package services;


public interface Connector<T> {

   T pull(String url) throws Exception;

}
