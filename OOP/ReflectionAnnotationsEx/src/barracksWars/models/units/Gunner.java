package barracksWars.models.units;

public class Gunner extends AbstractUnit {
    private static final int GUNNER_HEALTH = 40;
    private static final int GUNNER_DAMAGE = 13;

    public Gunner() {
        super(GUNNER_HEALTH, GUNNER_DAMAGE);
    }
}
