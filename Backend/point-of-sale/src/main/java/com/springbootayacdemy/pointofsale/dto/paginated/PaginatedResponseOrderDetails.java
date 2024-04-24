package com.springbootayacdemy.pointofsale.dto.paginated;

import com.springbootayacdemy.pointofsale.dto.response.ResponseOrderDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseOrderDetails {
    private List<ResponseOrderDetailsDto> list;
    private long dataCount;
}
