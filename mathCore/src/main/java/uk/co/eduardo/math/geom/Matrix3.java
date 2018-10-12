/*
 * Copyright (c) PRGX.
 * All Rights Reserved.
 */
package uk.co.eduardo.math.geom;

/**
 * Represents a 3x3 matrix.
 *
 * @author erodri02
 */
public class Matrix3
{
   /** The 3 x 3 identity matrix. */
   public static final Matrix3 IDENTITY = new Matrix3( 1, 0, 0, 0, 1, 0, 0, 0, 1 );

   /** Element at row 0 column 0. */
   public final double a00;

   /** Element at row 0 column 1. */
   public final double a01;

   /** Element at row 0 column 2. */
   public final double a02;

   /** Element at row 1 column 0. */
   public final double a10;

   /** Element at row 1 column 1. */
   public final double a11;

   /** Element at row 1 column 2. */
   public final double a12;

   /** Element at row 2 column 0. */
   public final double a20;

   /** Element at row 2 column 1. */
   public final double a21;

   /** Element at row 2 column 2. */
   public final double a22;

   /**
    * Initializes a new Matrix3 object.
    * <p>
    * Constructs the following matrix:
    *
    * <pre>
    *  &#x250C;               &#x2510;
    *  &#x2502; a00, a01, a02 &#x2502;
    *  &#x2502; a10, a11, a12 &#x2502;
    *  &#x2502; a20, a21, a22 &#x2502;
    *  &#x2514;               &#x2518;
    * </pre>
    * </p>
    *
    * @param a00 element at row 0 column 0.
    * @param a01 element at row 0 column 1.
    * @param a02 element at row 0 column 2.
    * @param a10 element at row 1 column 0.
    * @param a11 element at row 1 column 1.
    * @param a12 element at row 1 column 2.
    * @param a20 element at row 2 column 0.
    * @param a21 element at row 2 column 1.
    * @param a22 element at row 2 column 2.
    */
   public Matrix3( final double a00,
                   final double a01,
                   final double a02,
                   final double a10,
                   final double a11,
                   final double a12,
                   final double a20,
                   final double a21,
                   final double a22 )
   {
      this.a00 = a00;
      this.a01 = a01;
      this.a02 = a02;
      this.a10 = a10;
      this.a11 = a11;
      this.a12 = a12;
      this.a20 = a20;
      this.a21 = a21;
      this.a22 = a22;
   }

   /**
    * Calculates the result vector, r, by multiplying this matrix, M, with the specified vector, v:
    *
    * <pre>
    * r = M.v
    * </pre>
    *
    * @param v the vector with which to multiply this matrix.
    * @return the vector multiplied by this matrix.
    */
   public Vector3 mul( final Vector3 v )
   {
      final double r0 = ( this.a00 * v.x ) + ( this.a01 * v.y ) + ( this.a02 * v.z );
      final double r1 = ( this.a10 * v.x ) + ( this.a11 * v.y ) + ( this.a12 * v.z );
      final double r2 = ( this.a20 * v.x ) + ( this.a21 * v.y ) + ( this.a22 * v.z );
      return new Vector3( r0, r1, r2 );
   }

   /**
    * Calculates the result matrix, R, by multiplying this matrix, M, with the specified matrix, S:
    *
    * <pre>
    * R = M.S
    * </pre>
    *
    * @param S the matrix with which to compose this matrix.
    * @return the composition of this matrix and the other.
    */
   public Matrix3 mul( final Matrix3 S )
   {
      final double r00 = ( this.a00 * S.a00 ) + ( this.a01 * S.a10 ) + ( this.a02 * S.a20 );
      final double r01 = ( this.a00 * S.a01 ) + ( this.a01 * S.a11 ) + ( this.a02 * S.a21 );
      final double r02 = ( this.a00 * S.a02 ) + ( this.a01 * S.a12 ) + ( this.a02 * S.a22 );

      final double r10 = ( this.a10 * S.a00 ) + ( this.a11 * S.a10 ) + ( this.a12 * S.a20 );
      final double r11 = ( this.a10 * S.a01 ) + ( this.a11 * S.a11 ) + ( this.a12 * S.a21 );
      final double r12 = ( this.a10 * S.a02 ) + ( this.a11 * S.a12 ) + ( this.a12 * S.a22 );

      final double r20 = ( this.a20 * S.a00 ) + ( this.a21 * S.a10 ) + ( this.a22 * S.a20 );
      final double r21 = ( this.a20 * S.a01 ) + ( this.a21 * S.a11 ) + ( this.a22 * S.a21 );
      final double r22 = ( this.a20 * S.a02 ) + ( this.a21 * S.a12 ) + ( this.a22 * S.a22 );

      return new Matrix3( r00, r01, r02, r10, r11, r12, r20, r21, r22 );
   }

   /**
    * Calculates the result matix, R, by multiplying this matix, M, with the specified scalar, f.
    *
    * <pre>
    * R = M.f
    * </pre>
    *
    * @param factor the scale factor by which to multiply each element of this matrix.
    * @return the result of multiplying each element of this matrix by the scale factor.
    */
   public Matrix3 mul( final double factor )
   {
      return new Matrix3( this.a00 * factor,
                          this.a01 * factor,
                          this.a02 * factor,
                          this.a10 * factor,
                          this.a11 * factor,
                          this.a12 * factor,
                          this.a20 * factor,
                          this.a21 * factor,
                          this.a22 * factor );
   }

   /**
    * Calculates the determinant of this matrix.
    *
    * @return the determinant of the matrix.
    */
   public double det()
   {
      final double s1 = this.a00 * ( ( this.a11 * this.a22 ) - ( this.a12 * this.a21 ) );
      final double s2 = this.a01 * ( ( this.a10 * this.a22 ) - ( this.a12 * this.a20 ) );
      final double s3 = this.a02 * ( ( this.a10 * this.a21 ) - ( this.a11 * this.a20 ) );
      return ( s1 - s2 ) + s3;
   }

   /**
    * Calculates the inverse of the matrix, <code>M<sup>-1</sup></code>
    *
    * @return the matrix inverse or <code>null</code> if the inverse could not be calculated.
    */
   public Matrix3 inv()
   {
      final double det = det();
      if( det == 0 )
      {
         return null;
      }

      // Calculate matrix of minors with correct cofactor
      final double s00 = +1 * ( ( this.a11 * this.a22 ) - ( this.a12 * this.a21 ) );
      final double s01 = -1 * ( ( this.a10 * this.a22 ) - ( this.a12 * this.a20 ) );
      final double s02 = +1 * ( ( this.a10 * this.a21 ) - ( this.a11 * this.a20 ) );

      final double s10 = -1 * ( ( this.a01 * this.a22 ) - ( this.a02 * this.a21 ) );
      final double s11 = +1 * ( ( this.a00 * this.a22 ) - ( this.a02 * this.a20 ) );
      final double s12 = -1 * ( ( this.a00 * this.a21 ) - ( this.a01 * this.a20 ) );

      final double s20 = +1 * ( ( this.a01 * this.a12 ) - ( this.a02 * this.a11 ) );
      final double s21 = -1 * ( ( this.a00 * this.a12 ) - ( this.a02 * this.a10 ) );
      final double s22 = +1 * ( ( this.a00 * this.a11 ) - ( this.a01 * this.a10 ) );

      // Transpose and divide by determinant
      return new Matrix3( s00, s01, s02, s10, s11, s12, s20, s21, s22 ).transpose().mul( 1 / det );
   }

   /**
    * Returns the transpose of this matrix, <code>M<sup>T</sup></code>.
    *
    * @return the transpose of this matrix.
    */
   public Matrix3 transpose()
   {
      return new Matrix3( this.a00, this.a10, this.a20, this.a01, this.a11, this.a21, this.a02, this.a12, this.a22 );
   }

   /**
    * Creates a rotation matrix that rotates about the unit vector, v.
    *
    * @param v the vector about which to rotate. Must be a unit vector.
    * @param theta the number of degrees to rotate. If the vector v points to the viewer, then a positive value will rotate
    *           anticlockwise.
    * @return a rotation matrix for rotating around the given axis.
    */
   public static Matrix3 createRotationMatrix( final Vector3 v, final double theta )
   {
      final double ct = Math.cos( Math.toRadians( theta ) );
      final double st = Math.sin( Math.toRadians( theta ) );

      final double r00 = ct + ( v.x * v.x * ( 1 - ct ) );
      final double r01 = ( v.x * v.y * ( 1 - ct ) ) - ( v.z * st );
      final double r02 = ( v.x * v.z * ( 1 - ct ) ) + ( v.y * st );
      final double r10 = ( v.y * v.x * ( 1 - ct ) ) + ( v.z * st );
      final double r11 = ct + ( v.y * v.y * ( 1 - ct ) );
      final double r12 = ( v.y * v.z * ( 1 - ct ) ) - ( v.x * st );
      final double r20 = ( v.z * v.x * ( 1 - ct ) ) - ( v.y * st );
      final double r21 = ( v.z * v.y * ( 1 - ct ) ) + ( v.x * st );
      final double r22 = ct + ( v.z * v.z * ( 1 - ct ) );

      return new Matrix3( r00, r01, r02, r10, r11, r12, r20, r21, r22 );
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public String toString()
   {
      return String.format( "| %.3f, %.3f, %.3f |\n| %.3f, %.3f, %.3f |\n| %.3f, %.3f, %.3f |", //$NON-NLS-1$
                            this.a00,
                            this.a01,
                            this.a02,
                            this.a10,
                            this.a11,
                            this.a12,
                            this.a20,
                            this.a21,
                            this.a22 );
   }
}
