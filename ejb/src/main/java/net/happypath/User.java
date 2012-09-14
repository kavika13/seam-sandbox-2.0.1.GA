package net.happypath;

import java.io.Serializable;

import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.ScopeType;

@Entity
@Name("user")
@Scope(ScopeType.SESSION)
public class User implements Serializable
{
   private String username;
   private String name;
   private String password;
   private Gender gender = Gender.Unspecified;

   public User(String username, String name, String password)
   {
      this.name = name;
      this.password = password;
      this.username = username;
   }

   public User()
   {
   }

   @Id
   @NotNull
   @Length(min=5, max=15)
   public String getUsername()
   {
      return username;
   }
   public void setUsername(String username)
   {
      this.username = username;
   }

   @NotNull
   public String getName()
   {
      return name;
   }
   public void setName(String name)
   {
      this.name = name;
   }

   @NotNull
   @Length(min=5, max=15)
   public String getPassword()
   {
      return password;
   }
   public void setPassword(String password)
   {
      this.password = password;
   }

   @NotNull
   @Enumerated(EnumType.ORDINAL)
   public Gender getGender()
   {
      return gender;
   }
   public void setGender(Gender gender)
   {
      this.gender = gender;
   }

   public enum Gender
   {
      Unspecified,
      Male,
      Female,
      Other;
   }
}
