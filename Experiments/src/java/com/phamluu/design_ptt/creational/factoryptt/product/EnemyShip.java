package com.phamluu.design_ptt.creational.factoryptt.product;

public abstract class EnemyShip
{

  private String name;
  private double speed;
  private double directionX;
  private double directionY;
  private double amtDamage;

  public String getName()
  {
    return name;
  }

  public void setName(String newName)
  {
    name = newName;
  }

  public double getDamage()
  {
    return amtDamage;
  }

  public void setDamage(double newDamage)
  {
    amtDamage = newDamage;
  }

  public void followHeroShip()
  {
    System.out.println(getName() + " is following the hero");
  }

  public void displayEnemyShip()
  {
    System.out.println(getName() + " is on the screen");
  }

  public void enemyShipShoots()
  {
    System.out.println(getName() + " attacks and does " + getDamage() + " damage to hero");
  }

  public double getSpeed()
  {
    return speed;
  }

  public void setSpeed(double speed)
  {
    this.speed = speed;
  }

  public double getDirectionX()
  {
    return directionX;
  }

  public void setDirectionX(double directionX)
  {
    this.directionX = directionX;
  }

  public double getDirectionY()
  {
    return directionY;
  }

  public void setDirectionY(double directionY)
  {
    this.directionY = directionY;
  }

}
