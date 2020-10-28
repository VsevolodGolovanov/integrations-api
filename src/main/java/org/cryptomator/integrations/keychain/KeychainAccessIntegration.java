package org.cryptomator.integrations.keychain;

/**
 * This is the interface used by Cryptomator to store passwords securely in external keychains, such as system keychains or password managers.
 */
public interface KeychainAccessIntegration {

	/**
	 * Associates a passphrase with a given key.
	 *
	 * @param key        Key used to retrieve the passphrase via {@link #loadPassphrase(String)}.
	 * @param passphrase The secret to store in this keychain.
	 */
	void storePassphrase(String key, CharSequence passphrase) throws KeychainAccessException;

	/**
	 * @param key Unique key previously used while {@link #storePassphrase(String, CharSequence) storing a passphrase}.
	 * @return The stored passphrase for the given key or <code>null</code> if no value for the given key could be found.
	 */
	char[] loadPassphrase(String key) throws KeychainAccessException;

	/**
	 * Deletes a passphrase with a given key.
	 *
	 * @param key Unique key previously used while {@link #storePassphrase(String, CharSequence) storing a passphrase}.
	 */
	void deletePassphrase(String key) throws KeychainAccessException;

	/**
	 * Updates a passphrase with a given key. Noop, if there is no item for the given key.
	 *
	 * @param key        Unique key previously used while {@link #storePassphrase(String, CharSequence) storing a passphrase}.
	 * @param passphrase The secret to be updated in this keychain.
	 */
	void changePassphrase(String key, CharSequence passphrase) throws KeychainAccessException;

	/**
	 * @return <code>true</code> if this KeychainAccessStrategy works on the current machine.
	 * @implNote This method must not throw any exceptions and should fail fast
	 * returning <code>false</code> if it can't determine availability of the checked strategy
	 */
	boolean isSupported();

}
