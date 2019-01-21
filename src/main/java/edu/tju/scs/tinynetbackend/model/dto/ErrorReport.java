package edu.tju.scs.tinynetbackend.model.dto;

import lombok.*;


@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ErrorReport {

    @Getter
    @Setter
    @NonNull
    private int errno;

    @Getter
    @Setter
    @NonNull
    private String errmsg;

    @Getter
    @Setter
    private ResponseData data;



}
