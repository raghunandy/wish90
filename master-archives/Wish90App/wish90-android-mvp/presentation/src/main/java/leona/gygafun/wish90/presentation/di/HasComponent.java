/* Wish90 */
package leona.gygafun.wish90.presentation.di;

/**
 * Interface representing a contract for clients that contains a component for dependency injection.
 */
public interface HasComponent<C> {
  C getComponent();
}
