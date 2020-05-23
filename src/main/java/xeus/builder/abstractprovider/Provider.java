package xeus.builder.abstractprovider;

import org.apache.commons.lang3.builder.Builder;

public abstract class Provider<T extends Builder<?>> {

    protected T builder;

    @SuppressWarnings("unchecked")
    void setBuilder(Builder<?> builder) {
        this.builder = (T) builder;
    }

    public static <P extends Provider<? extends Builder<?>>> P getInstanceOf(
            Class<P> clazz, Builder<?> builder) {

        try {
            P provider = clazz.getDeclaredConstructor().newInstance();
            provider.setBuilder(builder);
            return provider;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
