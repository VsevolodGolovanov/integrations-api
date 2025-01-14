package org.cryptomator.integrations.mount;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Range;

import java.nio.file.Path;

/**
 * Builder to mount a filesystem.
 * <p>
 * The setter may attempt to validate the input, but {@link #mount()} may still fail due to missing or invalid (combination of) options.
 * This holds especially for {@link MountBuilder#setMountFlags(String)};
 */
public interface MountBuilder {

	/**
	 * Sets the mount point.
	 *
	 * @param mountPoint Where to mount the volume
	 * @return <code>this</code>
	 * @see MountProvider#getDefaultMountPoint(String)
	 */
	@Contract("_ -> this")
	MountBuilder setMountpoint(Path mountPoint);

	/**
	 * Sets mount flags.
	 *
	 * @param mountFlags Mount flags
	 * @return <code>this</code>
	 * @throws UnsupportedOperationException If {@link MountFeature#MOUNT_FLAGS} is not supported
	 * @see MountProvider#getDefaultMountFlags(String)
	 */
	@Contract("_ -> this")
	default MountBuilder setMountFlags(String mountFlags) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Instructs the mount to be read-only.
	 *
	 * @param mountReadOnly Whether to mount read-only.
	 * @return <code>this</code>
	 * @throws UnsupportedOperationException If {@link MountFeature#READ_ONLY} is not supported
	 */
	@Contract("_ -> this")
	default MountBuilder setReadOnly(boolean mountReadOnly) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Use the given TCP port.
	 *
	 * @param port fixed TCP port or 0 to use a system-assigned port
	 * @return <code>this</code>
	 * @throws UnsupportedOperationException If {@link MountFeature#PORT} is not supported
	 */
	@Contract("_ -> this")
	default MountBuilder setPort(@Range(from = 0, to = Short.MAX_VALUE) int port) {
		throw new UnsupportedOperationException();
	}


	/**
	 * Mounts the file system.
	 *
	 * @return A mount handle
	 * @throws MountFailedException If mounting failed
	 */
	@Contract(" -> new")
	Mount mount() throws MountFailedException;

}
