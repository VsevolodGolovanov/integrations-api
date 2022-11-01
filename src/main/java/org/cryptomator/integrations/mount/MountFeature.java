package org.cryptomator.integrations.mount;

import java.nio.file.Path;

/**
 * Describes what aspects of the mount implementation can or should be used.
 * <p>
 * This may be used to show or hide different configuration options depending on the chosen mount provider.
 */
public enum MountFeature {
	/**
	 * The provider supports {@link MountProvider#getDefaultMountFlags(String)}
	 * and the builder requires {@link MountBuilder#setMountFlags(String)}.
	 */
	MOUNT_FLAGS,

	/**
	 * With the exception of a provider-supplied default mount point, the mount point must be an existing dir.
	 * <p>
	 * This option is mutually exclusive with {@link #MOUNT_WITHIN_EXISTING_PARENT}.
	 *
	 * @see #MOUNT_TO_SYSTEM_CHOSEN_PATH
	 */
	MOUNT_TO_EXISTING_DIR,

	/**
	 * With the exception of a provider-supplied default mount point, the mount point must be a non-existing
	 * child within an existing parent.
	 * <p>
	 * This option is mutually exclusive with {@link #MOUNT_TO_EXISTING_DIR}.
	 *
	 * @see #MOUNT_TO_SYSTEM_CHOSEN_PATH
	 */
	MOUNT_WITHIN_EXISTING_PARENT,

	/**
	 * The mount point may be a drive letter.
	 *
	 * @see #MOUNT_TO_EXISTING_DIR
	 * @see #MOUNT_WITHIN_EXISTING_PARENT
	 * @see #MOUNT_TO_SYSTEM_CHOSEN_PATH
	 */
	MOUNT_AS_DRIVE_LETTER,

	/**
	 * The provider supports suggesting a default mount point, if no mount point is set via {@link MountBuilder#setMountpoint(Path)}.
	 */
	MOUNT_TO_SYSTEM_CHOSEN_PATH,

	/**
	 * The provider supports {@link MountProvider#getDefaultPort()}
	 * and the builder requires {@link MountBuilder#setPort(int)}.
	 */
	PORT,

	/**
	 * The builder supports {@link MountBuilder#setReadOnly(boolean)}.
	 */
	READ_ONLY,

	/**
	 * The mount supports {@link Mount#unmountForced()}.
	 */
	UNMOUNT_FORCED,

	/**
	 * The builder requires {@link MountBuilder#setVolumeId(String)}.
	 */
	VOLUME_ID
}
