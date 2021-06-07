/*-
 * LICENSE
 * DiscordSRV
 * -------------
 * Copyright (C) 2016 - 2021 Austin "Scarsz" Shapiro
 * -------------
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * END
 */

package github.scarsz.discordsrv.linking.store;

import github.scarsz.discordsrv.linking.provider.MinecraftAccountProvider;
import lombok.NonNull;
import net.dv8tion.jda.api.entities.User;
import org.bukkit.OfflinePlayer;

import javax.annotation.Nullable;
import java.util.UUID;

/**
 * Represents a storage media for Minecraft accounts
 */
public interface MinecraftAccountStore extends AccountStore, MinecraftAccountProvider {

    void setLinkedMinecraft(@NonNull String discordId, @Nullable UUID playerUuid);
    default void setLinkedMinecraft(@NonNull String discordId, @Nullable OfflinePlayer player) {
        setLinkedMinecraft(discordId, player != null ? player.getUniqueId() : null);
    }
    default void setLinkedMinecraft(@NonNull User user, @Nullable UUID playerUuid) {
        setLinkedMinecraft(user.getId(), playerUuid);
    }
    default void setLinkedMinecraft(@NonNull User user, @Nullable OfflinePlayer player) {
        setLinkedMinecraft(user, player != null ? player.getUniqueId() : null);
    }

}
