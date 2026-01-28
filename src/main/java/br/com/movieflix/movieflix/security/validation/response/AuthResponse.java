package br.com.movieflix.movieflix.security.validation.response;

    public record AuthResponse(
            int status,
            String error,
            String message,
            String path
    ) {

      public static AuthResponse of (
              int status,
              String error,
              String message,
              String path
      ){
         return new AuthResponse(
                 status,
                 error,
                 message,
                 path
         );
      }

    }

