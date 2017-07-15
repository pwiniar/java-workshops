package design.paterns;

/**
 * Created by Winiar on 13.07.2017.
 */
public abstract class MagicWeapon {

    protected MagicWeaponImpl imp;

    public MagicWeapon(MagicWeaponImpl impl) {
        this.imp = impl;
    }

    public abstract void wield();

    public abstract void swing();

    public abstract void unwield();

    public MagicWeaponImpl getImp() {
        return imp;
    }
}
