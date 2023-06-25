package guard.check.checks;

import guard.check.Category;
import guard.check.Check;
import guard.check.CheckInfo;
import guard.check.CheckTest;
import guard.data.PlayerData;
import io.github.retrooper.packetevents.event.impl.PacketPlayReceiveEvent;
import org.bukkit.potion.PotionEffectType;
@CheckInfo(name = "Jump A", category = Category.MOVEMENT)
public class JumpA extends CheckTest {

    int TickJump;
    long last;

    public void onMove(PacketPlayReceiveEvent packet, double motionX, double motionY, double motionZ, double lastmotionX, double lastmotionY, double lastmotionZ, float deltaYaw, float deltaPitch, float lastdeltaYaw, float lastdeltaPitch) {
        if (data.canFlag2()) {
            if(motionY > 0.0) {
                if (!data.onLowBlock || !data.ground2) {
                    if (System.currentTimeMillis() - data.lasthurt > 1200 && !data.player.hasPotionEffect(PotionEffectType.JUMP) && (System.currentTimeMillis() - data.lasthurtother > 2400)) {


                        TickJump++;
                        // Bukkit.broadcastMessage("ticks: " + TickJump);
                        if (data.blockabove || data.isInLiquid || data.isOnLadder || data.aboveSlime || data.isonSlab || System.currentTimeMillis() - last < 200 || System.currentTimeMillis() - data.lastblockabove < 700) {
                            buffer = 0;
                        }
                    